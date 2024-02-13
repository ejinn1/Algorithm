function solution(numbers) {
    numbers = numbers.sort((a, b) => {
        const strA = String(a)
        const strB = String(b)
        return (strB + strA) - (strA + strB)
    })
    
    if(numbers[0] === 0){
        return "0"
    }
    
    return numbers.join('')
}