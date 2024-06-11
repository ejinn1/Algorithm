const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

function solution(land, bomb){
	
	const n = land.length
	const m = land[0].length
	let score = Array.from({length: n}, () => Array.from({length: m}).fill(0))
	const direction = [[0,0], [1,0], [-1,0], [0,1], [0,-1]]
	
	for(let [x, y] of bomb){
		x-=1
		y-=1
		for(let [dx, dy] of direction){
			let cx = x + dx
			let cy = y + dy
			
			if(cx >= 0 && cx < n && cy >= 0 && cy < m && land[cx][cy] !== '#'){
				let add = 0
				if(land[cx][cy] === '0'){
					add = 1
				} else if (land[cx][cy] === '@'){
					add = 2
				}
				
				score[cx][cy] += add
			}
		}
	}
	let res = 0
	for(let i=0 ; i<n ; i++){
		res = Math.max(res, ...score[i])
	}
	return res
}

let input = [];
let n = null
let k = null
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 1){
		[n, k] = input[0].split(' ').map(Number)
	}
	if(input.length === n+k+1){
		let land = input.slice(1, n+1).map((l) => l.split(' '))
		let bomb = input.slice(n+1, n+k+1).map((b) => b.split(' ').map(Number))

		let res = solution(land, bomb)
		console.log(res)
		
		
		rl.close();
	}
	
});

rl.on('close', () => {
	process.exit(0)
})