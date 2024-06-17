const readline = require('readline');
let rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

function solution(str){
	let wordList = []
	const Score = new Set()

	for(let i=1 ; i<str.length ; i++){
		for(let j=i+1 ; j<str.length ; j++){
			const first = str.substring(0, i)
			const second = str.substring(i, j)
			const third = str.substring(j)
			wordList.push([first, second, third])
			Score.add(first)
			Score.add(second)
			Score.add(third)
		}
	}
	const tempScoreList = [...Score].sort();
	const wordScore = {};

	for (let i = 0; i < tempScoreList.length; i++) {
		wordScore[tempScoreList[i]] = i + 1;
	}

	let maxScore = -1;
	for (const words of wordList) {
			let tempScore = 0;
			for (const word of words) {
					tempScore += wordScore[word];
			}
			maxScore = Math.max(maxScore, tempScore);
	}

	console.log(maxScore);

	
	// abcde
	// abc d e
	// ab cd e
	// ab c de
	// a bcd e
	// a bc de
	// a b cde
	
	// a ab abc b bc bcd c cd cde d de e
}

let input = []
let n = null
rl.on('line', (line) => {
	input.push(line)
	if(input.length === 1) n = parseInt(input[0])
	if(input.length === 2) rl.close();
});

rl.on('close', () => {
	
	let str = input[1]
	solution(str)
})