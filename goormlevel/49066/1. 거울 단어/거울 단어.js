// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let N = null
	let lines = []
	
	for await (const line of rl) {
		if(N === null){
			N = line
		} else {
			lines.push(line)	
		}

		if(lines.length === N){
			rl.close();	
		}
	}

	const words = lines

	const mirrorMap = {
		'b': 'd',
		'd': 'b',
		'i': 'i',
		'l': 'l',
		'm': 'm',
		'n': 'n',
		'o': 'o',
		'p': 'q',
		'q': 'p',
		's': 'z',
		'z': 's',
		'u': 'u',
		'v': 'v',
		'w': 'w',
		'x': 'x'
	}

	words.forEach((word) => {
		const mirror = []
		word.split("").reverse().map((w) => {
			if(!(w in mirrorMap)){
				mirror.push('#')
			} else {
				mirror.push(mirrorMap[w])
			}
		})

		if(mirror.join("") === word){
			console.log("Mirror")
		} else {
			console.log("Normal")
		}
	})

	
	
	process.exit();
})();
