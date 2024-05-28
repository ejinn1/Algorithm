function solution(m, musicinfos) {
    
    let res = "(None)"
    
    function changeMelody(melody){
        let res = ""
        for(let i=0 ; i<melody.length ; i++){
            if(melody[i+1] === "#"){
                res += melody[i].toLowerCase()
                i++
            } else {
                res += melody[i]
            }
        }
        
        return res
    }
    
    m = changeMelody(m)
    
    function getMinute(time){
        let [h, m] = time.split(':')
        return Number(h)*60 + Number(m)
    }
    
    let max = 0
    musicinfos.forEach((info) => {
        let [start, end, title, song] = info.split(',')
        let play = getMinute(end) - getMinute(start)
        
        song = changeMelody(song)
        let melody = ""
        let q = Math.floor(play / song.length)
        let r = play % song.length
        
        for(let i=0 ; i<q ; i++){
            melody += song
        }
        for(let i=0 ; i<r ; i++){
            melody += song[i]
        }

        if(melody.includes(m) && play > max){
            max = play
            res = title
        }
    })
    
    return res
}