// Run by Node.js
const readline = require('readline');

function solution(n, area){
	const direction = [[-1, 0], [1, 0], [0, 1], [0, -1]]
	let cnt = 0
	
	while(true){
		let check = area.flat()
		let tmp = check.map((c, i) => c===0 ? i : -1).filter((i) => i!==-1)
		if(tmp.length === parseInt(n*n)) break
		cnt++
		
		for(let k of tmp){
			let x = parseInt(k/n)
			let y = k%n
			
			for(let [dx, dy] of direction){
				let cx = x + dx
				let cy = y + dy
				
				if(cx >= 0 && cx < n && cy >= 0 && cy < n && area[cx][cy] !== 0 ){
					area[cx][cy]--
				}
			}
		}
	}
	
	console.log(cnt)
	
}

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let lines = []
	let n = null
	for await (const line of rl) {
		if(!n) n = Number(line)
		else lines.push(line)
		
		if(lines.length === n) rl.close();
	}
	
	let area = lines.map((l) => l.split(' ').map(Number))
	solution(n, area)
	
	process.exit();
})();
