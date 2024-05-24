const readline = require('readline')

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function solution(a, b){
	console.log((a + b).toFixed(6))
}

rl.on('line', function(line){
	let lines = []
	lines.push(line.trim())
	
	if(lines.length === 1){
		let [a, b] = lines[0].split(' ').map(Number)
		solution(a, b)
		
		
		rl.close()
	}
}).on('close', function(){
	process.exit(0)
})


// const readline = require('readline');

// const solution = (data) => {
// };



// const lines = [];

// rl.on('line', function (line) {
//     lines.push(line.trim());
//     if (lines.length === 2) {  // 두 줄의 입력을 받은 후에 처리
//         const N = parseInt(lines[0], 10);
//         const data = lines[1].split(' ').map(Number);

//         if (data.length !== N) {
//             console.error('입력된 데이터의 개수가 일치하지 않습니다.');
//         } else {
//             solution(data);  // solution 함수 호출
//         }
        
//         rl.close();  // 입력 완료 후 readline 인터페이스 닫기
//     }
// }).on('close', function () {
//     process.exit(0);
// });
