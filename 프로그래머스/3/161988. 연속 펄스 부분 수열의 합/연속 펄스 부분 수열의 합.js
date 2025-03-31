function solution(sequence) {
    const n = sequence.length;
    
    for (let i = 0; i < n; i++) {
        sequence[i] *= (-1) ** i;
    }

    let maxSum1 = sequence[0];
    let maxSum2 = -sequence[0];
    let currentSum1 = sequence[0];
    let currentSum2 = -sequence[0];

    for (let i = 1; i < n; i++) {
        currentSum1 = Math.max(sequence[i], currentSum1 + sequence[i]);
        currentSum2 = Math.max(-sequence[i], currentSum2 - sequence[i]);
        maxSum1 = Math.max(maxSum1, currentSum1);
        maxSum2 = Math.max(maxSum2, currentSum2);
    }

    return Math.max(maxSum1, maxSum2);
}
