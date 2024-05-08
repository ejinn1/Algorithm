function solution(r1, r2) {
    let result = 0
    for (let i = 0; i <= r2; i++) {
        let minJ = Math.ceil(Math.sqrt(Math.max(0, r1 * r1 - i * i)))
        let maxJ = Math.floor(Math.sqrt(r2 * r2 - i * i))
        result += (maxJ - minJ + 1)
    }
    return 4 * result - (r2-r1+1)*4
}