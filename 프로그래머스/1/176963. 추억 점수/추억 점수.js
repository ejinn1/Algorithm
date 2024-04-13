function solution(name, yearning, photo) {
    const result = photo.map((sads) => {
        let sum = 0
        const idxs = sads.map((sad) => {
            return name.indexOf(sad)
        })
        
        idxs.map((idx) => {
            if(idx !== -1){
                sum += yearning[idx]
            }
        })
        
        return sum
    })
    
    return result
}