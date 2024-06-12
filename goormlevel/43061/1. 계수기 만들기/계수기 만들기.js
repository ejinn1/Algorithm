// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

function solution(maxs, inits, k){
	let i = inits.length-1
	while(k > 0){
		let tmp = k + inits[i]
		let d = tmp % (maxs[i]+1)
		let r = parseInt(tmp / (maxs[i]+1))
		inits[i] = d
		k = r
		i--
	}
	console.log(inits.join(''))
}

let lines = []
let n = null
rl.on("line", function(line) {
	lines.push(line)

	if(lines.length === 4){
		
		let maxs = lines[1].split(' ').map(Number)
		let inits = lines[2].split(' ').map(Number)
		let k = Number(lines[3])

		solution(maxs, inits, k)
		
		rl.close();
	}

}).on("close", function() {
	process.exit();
});