document.addEventListener('DOMContentLoaded', () => {
    const audioPlayer = document.getElementById('audioPlayer');
    const playPauseButton = document.getElementById('play-pause');
    const prevButton = document.getElementById('prev');
    const nextButton = document.getElementById('next');
    const songList = document.getElementById('song-list');
    const sidebar = document.getElementById('sidebar');
    const toggleSidebarButton = document.getElementById('toggle-sidebar');
    const songTitle = document.getElementById('song-title');
    const songImage = document.getElementById('song-image');
    const progressBar = document.getElementById('progress-bar');
    const currentTimeDisplay = document.getElementById('current-time');
    const durationDisplay = document.getElementById('duration');

    let isPlaying = false;
    let currentSongIndex = 0;
    let songs = [
        { title: 'Aadungada', file: 'Aadungada.mp3', image: 'https://c.saavncdn.com/432/Naadodigal-Tamil-2009-20200714115717-500x500.jpg' },
        { title: 'Aathichudi', file: 'Aathichudi.mp3', image: 'https://c.saavncdn.com/757/TN-07-AL-4777-Tamil-2008-500x500.jpg' },
        { title: 'Ada Ennatha Solvenungo', file: 'Ada-Ennatha-Solvenungo.mp3', image: 'https://c.saavncdn.com/121/Sivakasi-Tamil-2005-20190106133608-500x500.jpg' },
        { title: 'Adaludan Paadalai Kettu Remix', file: 'Adaludan-Paadalai-Kettu-Remix.mp3', image: 'https://c.saavncdn.com/707/Motta-Shiva-Ketta-Shiva-Tamil-2017-500x500.jpg' },
        { title: 'Ammadi Athadi', file: 'Ammadi-Athadi-MassTamilan.org.mp3', image: 'https://c.saavncdn.com/426/Vallavan-Tamil-2006-20230712130650-500x500.jpg' },
        { title: 'Appadi Podu', file: 'Appadi-Podu.mp3', image: 'https://c.saavncdn.com/278/Gilli-Tamil-Tamil-2004-20190110130805-500x500.jpg' },
        { title: 'Arjunar Villu', file: 'Arjunar-Villu.mp3', image: 'https://c.saavncdn.com/278/Gilli-Tamil-Tamil-2004-20190110130805-500x500.jpg' },
        { title: 'Azhagiya Laila', file: 'Azhagiya-Laila.mp3', image: 'https://i.ytimg.com/vi/1r_Zi4vLRQQ/maxresdefault.jpg' },
        { title: 'Chikni Chameli - Agneepath', file: 'Chikni-Chameli.mp3', image: 'https://c.saavncdn.com/317/Agneepath-Hindi-2011-20190603132941-500x500.jpg' },
        { title: 'Door Number', file: 'Door-Number.mp3', image: 'https://c.saavncdn.com/297/Thozha-Tamil-2016-500x500.jpg' },
        { title: 'Jingunamani', file: 'Jingunamani.mp3', image: 'https://c.saavncdn.com/155/Jilla-Tamil-2013-500x500.jpg' },
        { title: 'Kaadhal Yaanai', file: 'Kaadhal-Yaanai.mp3', image: 'https://c.saavncdn.com/820/Anniyan-Tamil-2005-20230712065521-500x500.jpg' },
        { title: 'Kannukulle Keluthi', file: 'Kannukulle-Keluthi.mp3', image: 'https://c-fa.cdn.smule.com/rs-s75/arr/eb/33/6014ff16-5374-4c5f-bd69-2672bd16474a.jpg' },
        { title: 'Karakudi Ilavarasi En Nenja', file: 'Karakudi-Ilavarasi-En-Nenja-MassTamilan.com.mp3', image: 'https://c.saavncdn.com/305/Kalakalappu-2-Tamil-2018-20180207-500x500.jpg' },
        { title: 'Kathadi Pole', file: 'Kathadi-Pole.mp3', image: 'https://c.saavncdn.com/006/Maayavi-Tamil-2006-20190531160602-500x500.jpg' },
        { title: 'Kokku Meenai Thinnuma', file: 'Kokku-Meenai-Thinnuma.mp3', image: 'https://c.saavncdn.com/575/Kovil-Tamil-2003-20190112024909-500x500.jpg' },
        { title: 'Pottu Thakku', file: 'Pottu-Thakku.mp3', image: 'https://c.saavncdn.com/044/Kuthu-Tamil-2004-20201214105740-500x500.jpg' },
        { title: 'Thanjavoor Jillakkari', file: 'Thanjavoor-Jillakkari.mp3', image: 'https://c.saavncdn.com/214/Suraa-Tamil-2010-20200620121922-500x500.jpg' },
        { title: 'Ussumu Laresay', file: 'Ussumu-Laresay.mp3', image: 'https://c.saavncdn.com/602/Uthama-Puthiran-Tamil-2010-500x500.jpg' },
        { title: 'Valayapatti', file: 'Valayapatti-MassTamilan.fm.mp3', image: 'https://c.saavncdn.com/082/Azagiya-Tamil-Magan-2007-500x500.jpg' }
    ];

    function updateSongInfo() {
        const song = songs[currentSongIndex];
        audioPlayer.src = `Music/${song.file}`;
        songTitle.textContent = song.title;
        songImage.src = song.image; 
        audioPlayer.load(); 
        audioPlayer.play();
        playPauseButton.innerHTML = '<i class="fas fa-pause"></i>';
        isPlaying = true;
    }

    function togglePlayPause() {
        if (isPlaying) {
            audioPlayer.pause();
        } else {
            audioPlayer.play();
        }
        isPlaying = !isPlaying;
        playPauseButton.innerHTML = isPlaying ? '<i class="fas fa-pause"></i>' : '<i class="fas fa-play"></i>';
    }

    function prevSong() {
        currentSongIndex = (currentSongIndex - 1 + songs.length) % songs.length;
        updateSongInfo();
        audioPlayer.play();
        playPauseButton.innerHTML = '<i class="fas fa-pause"></i>';
        isPlaying = true;
    }

    function nextSong() {
        currentSongIndex = (currentSongIndex + 1) % songs.length;
        updateSongInfo();
        audioPlayer.play();
        playPauseButton.innerHTML = '<i class="fas fa-pause"></i>';
        isPlaying = true;
    }

    function updateProgress() {
        const { currentTime, duration } = audioPlayer;
        progressBar.value = (currentTime / duration) * 100;
        currentTimeDisplay.textContent = formatTime(currentTime);
        durationDisplay.textContent = formatTime(duration);
    }

    function formatTime(time) {
        const minutes = Math.floor(time / 60);
        const seconds = Math.floor(time % 60);
        return `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
    }

    audioPlayer.addEventListener('timeupdate', updateProgress);

    audioPlayer.addEventListener('ended', nextSong);

    progressBar.addEventListener('input', () => {
        audioPlayer.currentTime = (progressBar.value / 100) * audioPlayer.duration;
    });

    toggleSidebarButton.addEventListener('click', () => {
        sidebar.classList.toggle('hidden');
    });

    playPauseButton.addEventListener('click', togglePlayPause);
    prevButton.addEventListener('click', prevSong);
    nextButton.addEventListener('click', nextSong);

    songs.forEach((song, index) => {
        const li = document.createElement('li');
        li.innerHTML = `<i class="fas fa-music"></i> ${song.title}`;
        li.addEventListener('click', () => {
            currentSongIndex = index;
            updateSongInfo();
            audioPlayer.play();
            playPauseButton.innerHTML = '<i class="fas fa-pause"></i>';
            isPlaying = true;
        });
        songList.appendChild(li);
    });

    updateSongInfo();
});
