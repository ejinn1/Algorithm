function solution(n, t, m, timetable) {
    timetable = timetable.map((time) => {
       const [h,m] = time.split(":").map(Number)
       return h*60 + m
    }).sort((a, b) => a - b)
    
    let busTime = 540
    let lastTime = 0
    let lastCnt = 0
    
    function formatTime(time){
        const h = Math.floor(time / 60).toString()
        const m = (time % 60).toString()
        return `${h.padStart(2, '0')}:${m.padStart(2, '0')}`
    }
    
    for (let i = 0; i < n; i++) {
        let cnt = 0
        let lastCrew = null

        while (cnt < m && timetable.length > 0 && timetable[0] <= busTime) {
            lastCrew = timetable.shift()
            cnt++
        }
        
        if (i === n - 1) {
            if (cnt < m) {
                return formatTime(busTime);
            } else {
                return formatTime(lastCrew - 1);
            }
        }

        busTime += t
    }
}
