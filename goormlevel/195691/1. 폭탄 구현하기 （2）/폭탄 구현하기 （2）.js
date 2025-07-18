const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

let lines = []
let N = null
let K = null

rl.on('line', (line) => {
	lines.push(line)
	if(lines.length === 1){
		[N, K] = lines[0].split(" ").map(Number)
		
	}

	if(lines.length === N + K + 1){
		rl.close();
	}
});

rl.on('close', () => {

	const grounds = lines.slice(1, N+1).map((i) => i.split(" "))
	const bombs = lines.slice(N+1, N+K+1).map((i) => i.split(" ").map(Number))
	const points = Array.from({length: N}, () => Array(N).fill(0))

	const dx = [0, 1, 0, -1]
	const dy = [1, 0, -1, 0]
	bombs.forEach(([x, y]) => {
		// check
		const option = grounds[x-1][y-1]
		if(option === '@'){
			points[x-1][y-1] += 2
		} else if(option === '0'){
			points[x-1][y-1] += 1
		}
		for(let i=0 ; i<4 ; i++){
			const cx = x - 1 + dx[i]
			const cy = y - 1+ dy[i]

			if(cx >= 0 && cx < N && cy >= 0 && cy < N){
				// check
				const option = grounds[cx][cy]
				if(option === '@'){
					points[cx][cy] += 2
				} else if(option === '0'){
					points[cx][cy] += 1
				}
			}
		}
	})

	let max = 0
	for(let i=0 ; i<N ; i++){
		for(let j=0 ; j<N ; j++){
			if(points[i][j] > max) max = points[i][j]
		}
	}

	console.log(max)
	
})
