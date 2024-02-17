function solution(sizes) {
    
    let maxW = 0
    let maxH = 0
    
    sizes.forEach((size) => {
        const [w, h] = size[0] < size[1] ? [size[1] , size[0]] : [size[0] , size[1]]
        
        maxW = Math.max(maxW, w)
        maxH = Math.max(maxH, h)
    })
        
    return maxW * maxH   
}