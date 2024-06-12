// Run by Node.js
const readline = require('readline');

function solution(H, rains, n, m){
	let rainedHouse = new Set()
	
	for(let i=0 ; i<rains.length ; i++){
		const [a,b] = rains[i]
		
		for(let j=a-1 ; j<b ; j++){
			H[j]++
			rainedHouse.add(j)
		}
		
		if((i+1)%3 === 0){
			for(let h of rainedHouse){
				H[h]--
			}
			rainedHouse.clear()
		}
	}
	
	console.log(H.join(' '))
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	let n = null
	let m = null

	for await (const line of rl) {
		lines.push(line)
		
		if(lines.length === 1){
			[n, m] = lines[0].split(' ').map(Number)
		}
		
		if(lines.length === m+2){
			rl.close();
		}
	}
	
	let houseH = lines[1].split(' ').map(Number)
	let rains = lines.slice(2).map((r) => r.split(' ').map(Number))
	
	solution(houseH, rains, n, m)
	
	process.exit();
})();
