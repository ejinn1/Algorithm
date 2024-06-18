const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

function solution(n, k, foods){
	let i = 0
	let score = 0
	while(k > 0 && i < foods.length){
		let [p, c] = foods[i]
		for(let j=0 ; j<p ; j++){
			if(k - 1 >= 0){
				score += c
				k--
			} else {
				break
			}
		}
		i++
	}
	
	console.log(score)
}
let input = []
let n = null
let k = null
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 1) [n, k] = input[0].split(' ').map(Number)
	if(input.length === n+1) rl.close();
});

rl.on('close', () => {
	
	let foods = input.slice(1).map((i) => i.split(' ').map(Number))
	foods = foods.map((food) => [food[0], parseInt(food[1] / food[0])])
	foods = foods.sort((a, b) => b[1] - a[1])

	solution(n, k, foods)
	
	
})