const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input = []
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 1){
		rl.close();
	}
});

rl.on('close', () => {
	let hp = Number(input[0])
	let cnt = 0
	cnt += Math.floor(hp / 14)
	hp %= 14
	cnt += Math.floor(hp / 7)
	hp %= 7
	cnt += hp
	
	console.log(cnt)
})