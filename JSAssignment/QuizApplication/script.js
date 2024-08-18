document.addEventListener("DOMContentLoaded", () => {
    let currentQuestion = 0;
    let score = 0;
    let playerName = '';
    let leaderboard = JSON.parse(localStorage.getItem('leaderboard')) || [];

    let userSelections = {};

    // Quiz data
    const quizData = {
        questions: [

            {
                id: 1,
                question: "What is the capital of France?",
                choices: ["Paris", "London", "Rome", "Berlin"],
                correctAnswer: "Paris"
            },
            {
                id: 2,
                question: "Which planet is known as the Red Planet?",
                choices: ["Earth", "Mars", "Jupiter", "Venus"],
                correctAnswer: "Mars"
            },
            {
                id: 3,
                question: "Who wrote 'Hamlet'?",
                choices: ["Charles Dickens", "Jane Austen", "Mark Twain", "William Shakespeare"],
                correctAnswer: "William Shakespeare"
            },
            {
                id: 4,
                question: "What is the largest ocean on Earth?",
                choices: ["Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"],
                correctAnswer: "Pacific Ocean"
            },
            {
                id: 5,
                question: "Which element has the chemical symbol 'O'?",
                choices: ["Osmium", "Oxygen", "Gold", "Oganesson"],
                correctAnswer: "Oxygen"
            },
            {
                id: 6,
                question: "Who is known as the Father of Computers?",
                choices: ["Charles Babbage", "Alan Turing", "Ada Lovelace", "John von Neumann"],
                correctAnswer: "Charles Babbage"
            },
            {
                id: 7,
                question: "What is the smallest prime number?",
                choices: ["0", "1", "2", "3"],
                correctAnswer: "2"
            },
            {
                id: 8,
                question: "What is the capital of Australia?",
                choices: ["Sydney", "Melbourne", "Canberra", "Brisbane"],
                correctAnswer: "Canberra"
            },
            {
                id: 9,
                question: "Who painted the Mona Lisa?",
                choices: ["Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet"],
                correctAnswer: "Leonardo da Vinci"
            },
            {
                id: 10,
                question: "What is the hardest natural substance on Earth?",
                choices: ["Gold", "Iron", "Diamond", "Platinum"],
                correctAnswer: "Diamond"
            }
        ]
    };

    function startQuiz() {
        playerName = document.getElementById('player-name').value.trim();
        if (playerName === '') {
            alert('Please enter your name to start the quiz.');
            return;
        }
        document.getElementById('name-entry').style.display = 'none';
        document.getElementById('quiz').style.display = 'block';
        document.getElementById('progress-bar').style.display = 'block';
        document.getElementById('button-container').style.display = 'flex';
        showQuestion(currentQuestion);
        updateNavigationButtons();
    }

    function showQuestion(index) {
        const quizContainer = document.getElementById('quiz');
        quizContainer.innerHTML = '';
        const question = quizData.questions[index];
        
        const questionCard = document.createElement('div');
        questionCard.className = 'question-card';

        const questionDiv = document.createElement('div');
        questionDiv.className = 'question';
        questionDiv.textContent = question.question;

        const choicesUl = document.createElement('ul');
        choicesUl.className = 'choices';

        question.choices.forEach((choice, choiceIndex) => {
            const li = document.createElement('li');
            const input = document.createElement('input');
            input.type = 'radio';
            input.name = `q${question.id}`;
            input.id = `q${question.id}_a${choiceIndex}`;
            input.value = choice;

            if (userSelections[question.id] === choice) {
                input.checked = true;
            }

            const label = document.createElement('label');
            label.htmlFor = input.id;
            label.textContent = choice;

            li.appendChild(input);
            li.appendChild(label);
            choicesUl.appendChild(li);

            input.addEventListener('change', () => {
                userSelections[question.id] = choice;
            });
        });

        questionCard.appendChild(questionDiv);
        questionCard.appendChild(choicesUl);
        quizContainer.appendChild(questionCard);

        updateProgressBar();
    }

    function updateProgressBar() {
        const progressBarFill = document.getElementById('progress-bar-fill');
        const progress = ((currentQuestion + 1) / quizData.questions.length) * 100;
        progressBarFill.style.width = progress + '%';
    }

    function updateNavigationButtons() {
        document.getElementById('prev').style.display = currentQuestion === 0 ? 'none' : 'inline-block';
        document.getElementById('next').style.display = currentQuestion === quizData.questions.length - 1 ? 'none' : 'inline-block';
        document.getElementById('submit').style.display = currentQuestion === quizData.questions.length - 1 ? 'inline-block' : 'none';
    }

    window.nextQuestion = function() {
        if (currentQuestion < quizData.questions.length - 1) {
            currentQuestion++;
            showQuestion(currentQuestion);
            updateNavigationButtons();
        }
    };

    window.prevQuestion = function() {
        if (currentQuestion > 0) {
            currentQuestion--;
            showQuestion(currentQuestion);
            updateNavigationButtons();
        }
    };

    window.submitQuiz = function() {
        score = 0;

        quizData.questions.forEach((question) => {
            const userAnswer = userSelections[question.id];
            if (userAnswer === question.correctAnswer) {
                score++;
            }
        });

        document.getElementById('quiz').style.display = 'none';
        document.getElementById('progress-bar').style.display = 'none';
        document.getElementById('button-container').style.display = 'none';

        const resultDiv = document.getElementById('result');
        resultDiv.style.display = 'block';
        document.getElementById('player-name-display').textContent = playerName;
        document.getElementById('player-score').textContent = score;
        document.getElementById('total-questions').textContent = quizData.questions.length;

        updateLeaderboard();
    };

    function updateLeaderboard() {
        leaderboard.push({ name: playerName, score: score });
        leaderboard.sort((a, b) => b.score - a.score);
        localStorage.setItem('leaderboard', JSON.stringify(leaderboard));

        showLeaderboard();
    }

    function showLeaderboard() {
        const leaderboardDiv = document.getElementById('leaderboard');
        leaderboardDiv.innerHTML = '<ol>' + leaderboard.map(player => `<li>${player.name} - ${player.score}</li>`).join('') + '</ol>';
        document.getElementById('modal-overlay').style.display = 'flex';
    }

    window.closeModal = function() {
        document.getElementById('modal-overlay').style.display = 'none';
    };

    document.getElementById('start-quiz-button').addEventListener('click', startQuiz);
});
