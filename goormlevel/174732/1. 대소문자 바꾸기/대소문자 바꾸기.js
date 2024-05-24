const readline = require('readline')

const rl = readline.createInterface({
	input : process.stdin,
	output: process.stdout
})

function solution(str) {
    let result = ''
    for (let char of str) {
        if (char >= 'a' && char <= 'z') {
            result += char.toUpperCase()
        } else {
            result += char.toLowerCase()
        }
    }
    return result;
}

let lines = []
rl.on('line', function(line){
		lines.push(line.trim())
	
		if(lines.length === 2){
			const N = lines[0]
			const str = lines[1]
			const res = solution(str)
			
			console.log(res)
			rl.close()
		}
}).on('close', function(){
	process.exit(0)
})