let currentQuestionIndex = 0;
let correctAnswers = 0;
const totalQuestions = 5;
let questions = [];
let startTime;
let username = '';
let avgScore = 0.0;
let avgTime = 0.0;
let userLevel =  210;
var getUrl;
var baseUrl;
let dragonHealth = 100;


// Add DOMContentLoaded listener for registration and login
document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM fully loaded and parsed');
    
    // Add event listeners
	/*
	if(localStorage.getItem('currentUsername') != null || ""){
		console.log("USERNAME ON REENTRY: " + localStorage.getItem('currentUsername'));
		username = localStorage.getItem('currentUsername');
		getUrl = window.location;
		baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
		startQuiz();
	}
	*/
    document.getElementById('registerButton').addEventListener('click', registerUser);
    document.getElementById('loginButton').addEventListener('click', loginUser);
    document.getElementById('submit').addEventListener('click', function() {
        submitAnswer();
        
        displayQuestion(questions);
    });
    document.getElementById('profile').addEventListener('click', function() {
        showProfile();
    });
    document.getElementById('playAgainButton').addEventListener('click', function() {
        playAgain();
    });
});

// Registration function
function registerUser() {
    username = document.getElementById('registerUsername').value;
    const password = document.getElementById('registerPassword').value;
    // Placeholder for registration request
    console.log('Registering:', username);
    // Simulate successful registration
    alert('Registration successful! Please log in.');
    // After registration, you might hide the registration form or auto-login the user
}


// Login function
function loginUser(){
    username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value; // Assuming you use it server-side
	getUrl = window.location;
	baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
	
	
	//add parentheses when going local, remove parentheses when pushing to prod
    fetch(baseUrl + 'LoginServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        credentials: 'include',
        body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`
    })
    .then(response => {
        if (response.ok) {
            localStorage.setItem('currentUsername', username); 
            console.log('Logging in:', username);
			
            startQuiz();
        } else {
            alert("Login failed!");
        }
    })
    .catch(error => console.error('Login failed:', error));
}


// Starts the quiz
function startQuiz() {
	console.log('START');
	console.log('START USER' + username);
    document.getElementById('registration').style.display = 'none';
    document.getElementById('login').style.display = 'none';
	document.getElementById('welcomeSection').style.display = 'none';
	document.getElementById('instructionsSection').style.display = 'none';
    document.getElementById('quiz-container').style.display = 'block';
	
    document.getElementById('leaderboard').style.display = 'none';
    document.getElementById('profile').style.display = 'none';
	document.getElementById('battleSection').style.display = 'block';
	
    generateQuestions();
    
    startTime = new Date(); // Start the timer
}



// Function to generate questions
async function generateQuestions() {
    console.log('GENERATE');
	let questionType = "addition";
	let worksheetType = "worksheet30";
	let worksheetTypes = [];
	document.getElementById('quiz-container').style.display = 'block';
	
     try {
        await fetchUserLevel(username);  // Assuming fetchUserLevel returns a Promise
        console.log("USER LEVEL: " + userLevel);

        
        if (userLevel <= 199) {
			
			worksheetTypes = ["worksheet1", "worksheet6", "worksheet23"];
			/*
			let random = Math.floor(Math.random() * 3) + 1;
			if (random == 1){
				questionType = "mixed";
				worksheetType = "worksheet1";
			}
			if (random == 2){
				questionType = "mixed2";	
				worksheetType = "worksheet6";	
			}
			if (random == 3){
				questionType = "mixed2";
				worksheetType = "worksheet23";
						
			}
			*/
            
        } else if (userLevel <= 299) {
			
			worksheetTypes = ["worksheet2", "worksheet7", "worksheet3"]
	
			
			/*
			let random = Math.floor(Math.random() * 3) + 1;
			if (random == 1){
				questionType = "grade2";
				worksheetType = "worksheet2";
			}
			if (random == 2){
				questionType = "grade3";
				worksheetType = "worksheet7";
						
			}
			if (random == 3){
				questionType = "grade4";
				//worksheetType = "worksheet20";
				worksheetType = "worksheet2";		
			}
			*/
			

			
        } else if (userLevel <= 399){
			
			worksheetTypes = ["worksheet4", "worksheet20", "worksheet21"]
			
			/*
			let random = Math.floor(Math.random() * 3) + 1;
			if (random == 1){
				questionType = "grade3";
				worksheetType = "worksheet7";
			}
			if (random == 2){
				questionType = "grade4";
				//worksheetType = "worksheet9";	
				//worksheetType = "worksheet21";	
				worksheetType = "worksheet7";		
			}
			if (random == 3){
				questionType = "grade5";
				//worksheetType = "worksheet21";	
				worksheetType = "worksheet7";		
			}
			*/
            
			
        } else if (userLevel <= 499) {
			
			worksheetTypes = ["worksheet8", "worksheet17", "worksheet11"];
			
			/*
			let random = Math.floor(Math.random() * 3) + 1;
			console.log("RANDOMMM:" + random);
			
			if (random == 1){
				questionType = "grade4";
				//worksheetType = "worksheet8";
				worksheetType = "worksheet14";
			}                                                                                                
			if (random == 2){
				questionType = "grade5";
				//worksheetType = "worksheet10";
				//worksheetType = "worksheet8";	
				//worksheetType = "worksheet22";
				worksheetType = "worksheet14";			
			}
			if (random == 3){
				questionType = "grade6";
				//worksheetType = "worksheet11";
				//worksheetType = "worksheet24";
				worksheetType = "worksheet14";				
			}                                
			*/                                                     
			
			
		}
		
		else if (userLevel <= 599) {
				
			worksheetTypes = ["worksheet27", "worksheet30", "worksheet31"];					
			/*						
					let random = Math.floor(Math.random() * 3) + 1;
					if (random == 1){
						questionType = "grade6";
						worksheetType = "worksheet17";
						
					}
					if (random == 2){
						questionType = "grade7";
						//worksheetType = "worksheet26";
						worksheetType = "worksheet17";
									
					}
					if (random == 3){
						questionType = "grade8";
						worksheetType = "worksheet31";			
					}	
			*/		
									
		}
		else if (userLevel <= 699) {
									
				
			worksheetTypes = ["worksheet17", "worksheet29", "worksheet31"];	
			/*				
					let random = Math.floor(Math.random() * 3) + 1;
					if (random == 1){
						questionType = "grade6";
						//worksheetType = "worksheet18";
						worksheetType = "worksheet27";		
					}
					if (random == 2){
						questionType = "grade7";
						worksheetType = "worksheet27";				
					}
					if (random == 3){
						questionType = "grade8";
						//worksheetType = "worksheet32";
						worksheetType = "worksheet31";					
					}			
					*/
									
		}
		else if (userLevel <= 799) {
				worksheetTypes = ["worksheet12", "worksheet13", "worksheet30"]	
				/*						
											
							let random = Math.floor(Math.random() * 4) + 1;
							if (random == 1){
								questionType = "grade6";
								worksheetType = "worksheet12";	
							}
							if (random == 2){
								questionType = "grade7";
								//worksheetType = "worksheet28";
								worksheetType = "worksheet12";				
							}
							if (random == 3){
								questionType = "grade8";
								worksheetType = "worksheet33";				
							}
							if (random == 3){
								questionType = "grade8";
								worksheetType = "worksheet30";				
							}	
							*/		
											
	   }
	   else if (userLevel <= 899) {
		
			worksheetTypes = ["worksheet13", "worksheet29", "worksheet30"];
	   									
	   				/*					
	   					let random = Math.floor(Math.random() * 3) + 1;
	   					if (random == 1){
	   						questionType = "grade6";
	   						worksheetType = "worksheet13";	
	   					}
	   					if (random == 2){
	   						questionType = "grade7";
	   						worksheetType = "worksheet29";				
	   					}
	   					if (random == 3){
	   						questionType = "grade8";
	   						worksheetType = "worksheet30";				
	   					}		
						*/	
	   									
	  }
        // Continue with your logic
    } catch (error) {
        console.error("Error in generating questions:", error);
    }
	
	
	const url = baseUrl + 'getWorksheet';
	console.log(url);
	
	
	for(let index = 0; index < 5; index++){
		let randomSheet = Math.floor(Math.random() * 3);
		const data = {
			      wsType: worksheetTypes[randomSheet],
			      input1: '1',
			      input2: '6',
			      input3: '5',
			      input4: '3',
			      input5: '4',
			      numberofquestions: 1
		};
	    fetch(url, {
	        method: 'POST', // or 'GET' if you want to use doGet method
	        headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	        },
	        body: new URLSearchParams(data) // This will properly encode the parameters
	    })
	    .then(response => {
	        if (!response.ok) {
	            throw new Error('Network response was not ok ' + response.statusText);
	            console.log('ERROR1');
	        }
	        return response.json(); // or return response.text() if the response is not JSON
	    })
	    .then(data => {
			console.log("USER LEVEL3: " + userLevel);
	        console.log('Questions received:', data);
	        questions.push(data);
	        console.log('QUESTIONSSS111: '+ questions);
	    	
	    	console.log('INDEX: ' + index + ' Question: ' + data.questionText + ' Answer: ' + data.answerText);
	         // Implement this function to handle the display of questions
	        console.log('NEW QUESTIONS');
	        
	        if (index == 4){
				console.log('QUESTIONSSS2: '+ questions);
	 			displayQuestion(questions); 
			}
	    })
	    .catch(error => {
			console.log('ERROR');
	        console.error('Failed to fetch questions:', error);
	    });
	    
	 }
	 
	 
}

// Function to display the current question
function displayQuestion() {
	console.log('DISPLAY');
	
	//console.log("QUESTION TEXT" + data.questionText);
	
	console.log('QUESTIONSSS: ' + questions);
    if (currentQuestionIndex < questions.length) {
        const question = questions[currentQuestionIndex];
        console.log('CURRENT QUESTION INDEX: ' +currentQuestionIndex);
		
        document.getElementById('question').textContent = `${question.questionText}`;
		
        document.getElementById('progress').textContent = `Question ${currentQuestionIndex + 1} of ${totalQuestions}`;
    } else {
		endQuiz();
    }
}

function displayQuestion(questions) {
	console.log('DISPLAY');
	
	//console.log("QUESTION TEXT" + data.questionText);	
	console.log('QUESTIONSSS: ' + questions);
    if (currentQuestionIndex < questions.length) {
        const question = questions[currentQuestionIndex];
        console.log('CURRENT QUESTION INDEX: ' +currentQuestionIndex);
		console.log("QUESTION TEXT" + question.questionText);
		
		document.getElementById('question').textContent = `${question.questionText}`;
		
        document.getElementById('progress').textContent = `Question ${currentQuestionIndex + 1} of ${totalQuestions}`;
    } else {
		console.log("ENDING");
		endQuiz();
    }
}


function submitAnswer() {
    
	let userAnswer = document.getElementById('answer').value;

	if (!isNaN(userAnswer)) {
	    // If the input is a number, parse it as a float
	    userAnswer = parseFloat(userAnswer);
	} else {
	    // Otherwise, keep it as a string
	    userAnswer = userAnswer.toString();
	}
	
    let currentAnswer = questions[currentQuestionIndex]
    const question = questions[currentQuestionIndex];
    console.log(userAnswer, question.answerText);
	var isCorrect = false;
    if (userAnswer == question.answerText){
		correctAnswers++;
		isCorrect = true;
	}
    console.log('SUBMIT');
    document.getElementById('answer').value = '';
	updateBattleSection(isCorrect);
	
    
}

function updateBattleSection(isCorrect) {
    const dragonAvatar = document.getElementById('dragonAvatar');
	const wizardAvatar = document.getElementById('wizardAvatar');
    const battleFeedback = document.getElementById('battleFeedback');
    const dragonHealthText = document.getElementById('dragonHealthText');
    const dragonHealthBar = document.getElementById('dragonHealth');

    if (isCorrect) {
		wizardAvatar.src = 'wizardshoot.png';
        dragonHealth -= 20; // Decrease dragon health for each correct answer
        if (dragonHealth <= 0) {
            dragonHealth = 0;
            // Dragon defeated
            dragonAvatar.src = 'dragon_defeated.png'; // Change to a defeated dragon image
            battleFeedback.textContent = "Dragon defeated!";
        } else {
            battleFeedback.textContent = `Hit! Dragon loses 20 health.`;
			
        }
    } else {
        battleFeedback.textContent = "Miss! The dragon is unharmed.";
    }

    // Update dragon health visually (e.g., change width of health bar)
    dragonHealthBar.style.width = `${dragonHealth}%`;
    dragonHealthText.textContent = dragonHealth; // Update health text

    // Clear the feedback after a few seconds
    setTimeout(() => {
        battleFeedback.textContent = '';
		wizardAvatar.src = 'the_wizard.png'
    }, 2000);
}

function showProfile() {
    // Hide other sections
    console.log("SHOW");
    document.getElementById('quiz-container').style.display = 'none';
    document.getElementById('leaderboard').style.display = 'none';
    document.getElementById('profile').style.display = 'block';
	document.getElementById('welcomeSection').style.display = 'none';
	document.getElementById('instructionsSection').style.display = 'none';
	document.getElementById('battleSection').style.display = 'none';
   	console.log("SHOW Username: " + username)
    fetchUserLeaderboard(username)
    document.getElementById('leaderboardHeader').textContent = username + "'s Top Scores";
}

function showQuiz() {
    // Hide other sections
    document.getElementById('registration').style.display = 'none';
    document.getElementById('login').style.display = 'none';
    document.getElementById('quiz-container').style.display = 'block';
    document.getElementById('leaderboard').style.display = 'none';
    document.getElementById('profile').style.display = 'none';
	document.getElementById('battleSection').style.display = 'block';
    
    displayQuestion(questions);
}



function endQuiz() {
	console.log('QUIZ OVER 2');
    const endTime = new Date();
    const timeTaken = ((endTime - startTime) / 1000).toFixed(2);
    document.getElementById('quiz-container').innerHTML = `<h2>Quiz Complete!</h2><p>Your score: ${correctAnswers} out of ${totalQuestions}</p><p>Total time taken: ${timeTaken} seconds</p>`;
    //postResultsAndFetchLeaderboard(correctAnswers, timeTaken);
    postResultsAndFetchLeaderboard(username, correctAnswers, timeTaken);
	document.getElementById('playAgainButton').style.display = 'block';
}



function saveResult(score, time) {
	const username = localStorage.getItem('currentUsername'); 
    let results = JSON.parse(localStorage.getItem('results')) || [];
    results.push({ username, score, time });
    localStorage.setItem('results', JSON.stringify(results));
}

function displayLeaderboard() {
	console.log('L');
    let results = JSON.parse(localStorage.getItem('results')) || [];
    results.sort((a, b) => b.score - a.score || a.time - b.time); // Sort by score, then by time

    const leaderboardList = document.getElementById('leaderboardList');
    leaderboardList.innerHTML = ''; // Clear previous entries
    results.forEach((result, index) => {
        const li = document.createElement('li');
        li.textContent = `${index + 1}. ${result.username} - Score: ${result.score}, Time: ${result.time} seconds`;
        leaderboardList.appendChild(li);
    });

    document.getElementById('leaderboard').style.display = 'block'; // Make the leaderboard visible
}

// Function to check the user's answer
function checkAnswer() {
    const userAnswer = parseInt(document.getElementById('answer').value, 10);
    console.log('CHECK');
    submitAnswer();
    //document.getElementById('answer').value = ''; // Clear the answer field after submission
    
}



function postResultsAndFetchLeaderboard(username, score, time) {
	console.log('LEADER2');
	console.log('USER:' + username);
    fetch(baseUrl + 'LeaderboardServlet', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `username=${encodeURIComponent(username)}&score=${score}&time=${time}`
    })
    .then(response => response.json())
    .then(data => {
        console.log(data.message);
        fetchLeaderboard();  // Refresh the leaderboard
    })
    .catch(error => console.error('Error posting results:', error));
}

function showLeaderboard() {
	console.log('LEADER');
    document.getElementById('quiz-container').style.display = 'none';
    document.getElementById('profile').style.display = 'none';
    document.getElementById('leaderboard').style.display = 'block';
	document.getElementById('welcomeSection').style.display = 'none';
	document.getElementById('instructionsSection').style.display = 'none';
    fetchLeaderboard(); // Make sure to refresh leaderboard data if needed
    document.getElementById('leaderboardHeader').textContent = "Global Top 10 Leaderboard";
}


function fetchLeaderboard() {
	console.log('LEADER3');
    fetch(baseUrl + 'LeaderboardServlet')
    .then(response => response.json())
    .then(data => updateLeaderboardDisplay(data))
    .catch(error => console.error('Error fetching leaderboard:', error));
}
/*
function updateLeaderboardDisplay(data) {
	console.log('LEADER4');
    const leaderboardList = document.getElementById('leaderboardList');
    leaderboardList.innerHTML = '';
    data.forEach((item, index) => {
        const entry = document.createElement('li');
        console.log("username:" + item.username);
        entry.textContent = `${index + 1}. ${item.username} - Score: ${item.score}, Time: ${item.time} seconds`;
        leaderboardList.appendChild(entry);
    });
    document.getElementById('leaderboard').style.display = 'block';
}
*/











function fetchUserLeaderboard(username) {
	console.log("PROFILEEEE");
    fetch(baseUrl + `ProfileServlet`)
    .then(response => {
        if (!response.ok) throw new Error('Failed to fetch leaderboard');
        console.log("PROFILEEEE2");
        return response.json();
    })
    .then(data => {
        updateLeaderboardDisplay(data);
    })
    .catch(error => console.error('Error fetching user leaderboard:', error));
}

function updateLeaderboardDisplay(data) {
	userLevel = 210;
	
	
    const leaderboardList = document.getElementById('leaderboardList');
    leaderboardList.innerHTML = '';
    let totalScore = 0.0;
    let totalTime = 0.0;
    let numEntries = 0;
    let count = 0;
     
    data.forEach((item, index) => {
		count = count + 1;
        const entry = document.createElement('li');
        if (count <= 10){
        	entry.textContent = `${index + 1}. Username: ${item.username} Score: ${item.score}, Time: ${item.time} seconds`;
        	leaderboardList.appendChild(entry);
        }
        totalScore = totalScore + item.score;
        totalTime = totalTime + item.time;
        numEntries = numEntries + 1;
    });
    avgScore = totalScore / numEntries;
    avgTime = totalTime / numEntries;
    
    userLevel = (totalScore * 2) + 100;
    
    document.getElementById('userLevel').textContent = userLevel;
    const entry2 = document.createElement('li');
    entry2.textContent = 'Average Score: ' + avgScore.toFixed(2) + ' Average Time: ' + avgTime.toFixed(2);
	
   	console.log(entry2.textContent);
    leaderboardList.appendChild(entry2);
    document.getElementById('leaderboard').style.display = 'block';    
}
function fetchUserLevel(username) {
    console.log("Fetching user level for:", username);
    return new Promise((resolve, reject) => {
        fetch(baseUrl + `ProfileServlet`)
        .then(response => {
            if (!response.ok) throw new Error('Failed to fetch user level');
            return response.json();
        })
        .then(data => {
            updateLevel(data); // Assume you have a function to calculate user level
            console.log("User level fetched:", userLevel);
            resolve(userLevel);  // Resolve the promise with the fetched user level
        })
        .catch(error => {
            console.error('Error fetching user leaderboard:', error);
            reject(error);
        });
    });
}


function playAgain() {
    // Reset quiz state
    currentQuestionIndex = 0;
    correctAnswers = 0;
    questions = [];
    dragonHealth = 100;

    // Hide the Play Again button
    document.getElementById('playAgainButton').style.display = 'none';

    // Start the quiz again
	location.reload();
    //startQuiz();
}


function updateLevel(data) {
	userLevel = 210;
	
    let totalScore = 0.0;
    let totalTime = 0.0;
    let numEntries = 0;
    let count = 0;
     
    data.forEach((item, index) => {
		
        totalScore = totalScore + item.score;
        totalTime = totalTime + item.time;
        numEntries = numEntries + 1;
    });
    avgScore = totalScore / numEntries;
    avgTime = totalTime / numEntries;
    
    userLevel = (totalScore * 2) + 100;
    console.log("USER LEVEL 2: " + userLevel);
       
}


/*document.addEventListener('DOMContentLoaded', function() {
    generateQuestions();
    displayQuestion();
    startTime = new Date(); // Start the timer

    document.getElementById('submit').addEventListener('click', function() {
        checkAnswer();
        document.getElementById('answer').value = ''; // Clear the answer field
    });
});
*/
document.getElementById('submit').addEventListener('click', function() {
    submitAnswer();
    currentQuestionIndex++;
    displayQuestion(questions);
    
});
document.getElementById('profile').addEventListener('click', function() {
    showProfile();
    
});
