function solution(n) {
    function sieveOfEratosthenes(n) {
        let primes = Array(n + 1).fill(true); // 모든 숫자를 소수로 가정
        primes[0] = primes[1] = false; // 0과 1은 소수가 아님

        for (let i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (let j = i * i; j <= n; j += i) {
                    primes[j] = false; // i의 배수를 소수가 아니라고 표시
                }
            }
        }

        return primes.reduce((acc, val, index) => {
            if (val) acc.push(index); // 소수인 인덱스만 추출
            return acc;
        }, []);
    }
    
    return sieveOfEratosthenes(n).length
}