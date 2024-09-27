function formatMin(time) {
    const [h,m] = time.split(":").map(Number)
    
    return h*60+m
}
function formatTime(min){
    const h = parseInt(min / 60,0)
    const m = min % 60
    
    return h.toString().padStart(2,0) + ":" + m.toString().padStart(2,0)
}

function solution(video_len, pos, op_start, op_end, commands) {
    const videoN = formatMin(video_len)
    const posN = formatMin(pos)
    const startN = formatMin(op_start)
    const endN = formatMin(op_end)
    let cur = posN
    
    if(cur >= startN && cur <= endN){
        cur = endN
    }

    for (const command of commands){ 
        if(command === "prev"){
            if(cur - 10 > 0){
                cur -= 10
            } else {
                cur = 0
            }
        } else if(command === "next"){
            if(cur + 10 < videoN){
                cur += 10
            } else {
                cur = videoN
            }
        } else {
            return null
        }
        
        if(cur >= startN && cur <= endN){
            cur = endN
        }
    }
    
    return formatTime(cur)
}