function solution(wallpaper) {
    const back = wallpaper.map((row) => {
        return row.split('')
    })
    
    let sx = Infinity
    let sy = Infinity
    let lx = 0
    let ly = 0
    
    for(let i=0 ; i<wallpaper.length ; i++){
        for(let j=0 ; j<wallpaper[0].length ; j++){
            if(wallpaper[i][j] === '#'){
                if(sx > i){
                    sx = i
                }
                if(sy > j){
                    sy = j
                }
                if(lx < i){
                    lx = i
                }
                if(ly < j){
                    ly = j
                }
            }
        }
    }
    
    return [sx, sy, lx+1, ly+1]
}