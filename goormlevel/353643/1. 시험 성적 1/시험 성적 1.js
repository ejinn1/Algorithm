// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	const lines = []
	let N = null

	for await (const line of rl) {
		lines.push(line)

		if(lines.length === N+1){
			rl.close()
		}	
	}

	N = Number(lines[0])
	const A = lines[1].split(" ").map(Number)
	const B = lines[2].split(" ").map(Number)
	let std = Array.from({length: N}).map((_, i) => A[i] + B[i])

	const result = new Array(N).fill(0)

	for(let i=0 ; i<N ; i++){
		for(let j=0 ; j<N ; j++){
			if(i !== j){
				if(A[i] < A[j] && B[i] < B[j]){
					result[i]++
				}
			}
		}
	}

	console.log(result.join(" "))
	
	
	process.exit();
})();
