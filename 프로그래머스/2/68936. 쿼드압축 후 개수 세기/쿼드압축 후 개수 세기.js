function solution(arr) {
    let res = [0,0]
    
    function compress(x, y, size){
        if(size === 1){
            res[arr[x][y]]++
            return
        }
        
        let k = arr[x][y]
        let f = true
        for(let i=x ; i<x+size ; i++){
            for(let j=y ; j<y+size ; j++){
                if(k !== arr[i][j]){
                    f = false
                    break
                }
            }
            if(!f) break
        }
        
        if(f){
            res[k]++
        } else {
            let half = size/2
            compress(x, y, half)
            compress(x, y+half, half)
            compress(x+half, y, half)
            compress(x+half, y+half, half)
        }
    }
    
    compress(0, 0, arr.length)
    
    return res
}