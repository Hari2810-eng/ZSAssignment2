let timer;
let seconds = 0;
let minutes = 0;
let hours = 0;

function startTimer() {
    if (timer) return; // Prevent multiple timers

    timer = setInterval(() => {
        seconds++;
        if (seconds === 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes === 60) {
            minutes = 0;
            hours++;
        }
        updateTimerDisplay();
    }, 1000);
}

function stopTimer() {
    clearInterval(timer);
    timer = null;
}

function resetTimer() {
    clearInterval(timer);
    timer = null;
    seconds = 0;
    minutes = 0;
    hours = 0;
    updateTimerDisplay();
}

function updateTimerDisplay() {
    document.getElementById('seconds').textContent = String(seconds).padStart(2, '0');
    document.getElementById('minutes').textContent = String(minutes).padStart(2, '0');
    document.getElementById('hours').textContent = String(hours).padStart(2, '0');
}
