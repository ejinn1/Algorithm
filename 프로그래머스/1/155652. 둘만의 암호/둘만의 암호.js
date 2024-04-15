function solution(s, skip, index) {
    const codeA = 'a'.charCodeAt()
    const codeZ = 'z'.charCodeAt()
    const skips = skip.split('').map((s) => s.charCodeAt())
    
    const result = s.split('').map((str) => {
        let code = str.charCodeAt()
        let step = 0
        
        while(step < index){
            code++
            if(code > codeZ){
                code = codeA
            }
            if(!skips.includes(code)){
                step++
            }
        }
        
        return String.fromCharCode(code)
        
    })
    
    return result.join('')
    
}