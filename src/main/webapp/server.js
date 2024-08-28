const express = require('express');
const http = require('http');
const socketIo = require('socket.io');
const cors = require('cors');  // Include CORS package

const app = express();
const server = http.createServer(app);
const io = socketIo(server, {
    cors: {
        origin: "http://localhost:8080",
        methods: ["GET", "POST"],
        credentials: true
    }
});

// Enable CORS for all routes and all origins
app.use(cors({
    origin: function(origin, callback) {
        const allowedOrigins = ['http://localhost:8080', 'http://localhost:3000'];
        if (!origin || allowedOrigins.indexOf(origin) !== -1) {
            callback(null, true);
        } else {
            callback(new Error('CORS not allowed'), false);
        }
    },
    credentials: true
}));

// Optionally, to restrict to specific origins, replace the above line with:
// app.use(cors({ origin: 'http://example.com' }));

// Questions array for demonstration purposes
app.use(express.static('webapp'));

const questions = [
    { id: 1, a: 5, b: 3, correctAnswer: 8 },
    { id: 2, a: 10, b: 15, correctAnswer: 25 },
    { id: 3, a: 7, b: 2, correctAnswer: 9 },
    { id: 4, a: 1, b: 1, correctAnswer: 2 },
    { id: 5, a: 12, b: 8, correctAnswer: 20 }
];

// Middleware to serve static files (HTML, CSS, JS)


app.get('/leaderboard', (req, res) => {
    const leaderboardData = [
        { username: "Alice", score: 10 },
        { username: "Bob", score: 8 }
    ];
    console.log('FETCHED');
    res.json(leaderboardData);
});

// Mock endpoint for posting results
app.post('/result', express.json(), (req, res) => {
    // Assuming you send the score and some user identification in the request
    console.log(req.body); // Log the incoming data
    res.json({ message: "Result saved successfully" });
});

// Handle a socket connection request from web clients
io.on('connection', (socket) => {
    console.log('New client connected');

    // Emitting a new question to the client
    socket.on('startQuiz', () => {
        if (questions.length > 0) {
            socket.emit('question', questions[0]); // Send the first question
        }
    });

    // Receiving answers and responding with results or next question
    socket.on('submitAnswer', (data) => {
        const question = questions.find(q => q.id === data.questionIndex + 1);
        let result = false;
        if (question && data.answer === question.correctAnswer) {
            result = true;
        }
        if (question) {
            const nextQuestion = questions[data.questionIndex + 1];
            socket.emit('answerResult', { correct: result, nextQuestion });
        } else {
            socket.emit('answerResult', { correct: result, nextQuestion: null });
        }
    });

    socket.on('disconnect', () => {
        console.log('User disconnected');
    });
});

const PORT = process.env.PORT || 8080;
server.listen(PORT, () => console.log(`Server running on port ${PORT}`));
