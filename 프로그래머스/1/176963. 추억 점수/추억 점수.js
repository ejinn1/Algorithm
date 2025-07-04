function solution(name, yearning, photo) {
    const pointMap = new Map()
    for(let i=0 ; i<name.length ; i++){
        pointMap.set(name[i], yearning[i])
    }
    
    const result = []
    for(let i=0 ; i<photo.length ; i++){
        const names = photo[i]
        let sum = 0
        for(let j=0 ; j<names.length ; j++){
            const point = pointMap.get(names[j]) || 0
            sum += point
        }
        
        result.push(sum)
    }
    
    return result
}