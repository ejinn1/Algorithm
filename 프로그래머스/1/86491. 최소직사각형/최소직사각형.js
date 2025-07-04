function solution(sizes) {
    for(let i=0 ; i<sizes.length ; i++){
        const [w, h] = sizes[i]
        
        if(w > h){
            sizes[i] = [h, w]
        }
    }
    
    const minW = Math.max(...sizes.map(([w, h]) => w))
    const minH = Math.max(...sizes.map(([w, h]) => h))
    
    return minW * minH
    
}