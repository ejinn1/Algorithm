// Run by Node.js
const readline = require('readline');

function getBest(m){
	let max = 0
	let res = 0
	
	let i = 0
	let j = 0
	while(j < m.length){
		
		let diff = m[j] - m[i]
		if(diff > 4){
			i++
		} else {
			let cnt = j-i+1
			if(cnt > max){
				max = cnt
				res = Math.floor((m[i] + m[j]) / 2)
			}
			j++
		}
	}
	
	return res
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	for await (const line of rl) {
		lines.push(line)
		
		if(lines.length === 3){
			rl.close();
		}
	}
	
	let a = lines[1].split(' ').map(Number).sort((a,b) => a-b)
	let b = lines[2].split(' ').map(Number).sort((a,b) => a-b)

	let aM = getBest(a)
	let bM = getBest(b)
	
	let res = aM > bM ? "good" : "bad"
	console.log(aM, bM)
	console.log(res)
	
	process.exit();
})();
