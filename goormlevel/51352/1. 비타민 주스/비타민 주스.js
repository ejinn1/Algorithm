const readline = require('readline');

function solution(juice) {
    const minCost = new Array(8).fill(Infinity);

    // 각 주스의 비타민 조합을 비트마스크로 변환하고 최소 비용 저장
    for (const [cost, vitamins] of juice) {
        let mask = 0;
        if (vitamins.includes('A')) mask |= 1; // 001
        if (vitamins.includes('B')) mask |= 2; // 010
        if (vitamins.includes('C')) mask |= 4; // 100
        
        minCost[mask] = Math.min(minCost[mask], cost);
    }

    let result = Infinity;

    // 모든 비타민 조합에 대한 최소 비용 계산
    for (let i = 1; i < 8; i++) {
			if(i === 7){
				result = Math.min(result, minCost[i])
			}
        for (let j = i; j < 8; j++) {
					if((i | j) === 7){
						result = Math.min(result, minCost[i] + minCost[j]);
					}
					for(let k = j ; k < 8 ; k++){
						if ((i | j | k) === 7) { // 모든 비타민(A, B, C) 포함
                result = Math.min(result, minCost[i] + minCost[j] + minCost[k]);
            }
					}
        }
    }

    return result === Infinity ? -1 : result;
}

(async () => {
    const rl = readline.createInterface({ input: process.stdin });
    const lines = [];
    let N = null;

    for await (const line of rl) {
        lines.push(line);
        if (lines.length === 1) {
            N = parseInt(lines[0], 10);
        }
        if (lines.length === N + 1) {
            rl.close();
        }
    }

    const juice = lines.slice(1).map(item => item.split(' ').map((v, i) => i === 0 ? parseInt(v, 10) : v));
    const result = solution(juice);
    
    console.log(result);
})();
