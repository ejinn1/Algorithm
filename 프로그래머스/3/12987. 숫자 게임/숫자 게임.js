function solution(A, B) {
    let result = 0

    A.sort((a, b) => a - b)
    B.sort((a, b) => a - b)

    let i = 0
    let j = 0

    while (i < A.length && j < B.length) {
        if (B[j] > A[i]) {
            result++
            i++
            j++
        } else {
            j++
        }
    }

    return result
}
