const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

function solution(hp, a, b){
	let cnt = 0
	if(hp % b === 0) return Math.floor(hp / b)
	for(let i=Math.floor(hp / b) ; i>=0 ; i--){
		if((hp - i*b) % a === 0){
			let cntA = Math.floor((hp - i*b) / a)
			cnt = i+cntA
			break
		}
	}
	if(cnt === 0) cnt = -1
	
	return cnt
}

let input = []
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 2) rl.close();
});

rl.on('close', () => {
	let hp = parseInt(input[0])
	let [a, b] = input[1].split(' ').map(Number)
	
	let res = solution(hp, a, b)
	console.log(res)
})