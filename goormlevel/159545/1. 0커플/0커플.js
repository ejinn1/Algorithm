const readline = require('readline');

const solution = (data) => {
	let sum = 0
    for(let i=0 ; i<data.length ; i++){
			sum += data[i]
		}
	return sum
};

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const lines = [];

rl.on('line', function (line) {
    lines.push(line.trim());
    if (lines.length === 2) {  // 두 줄의 입력을 받은 후에 처리
        const N = parseInt(lines[0], 10);
        const data = lines[1].split(' ').map(Number);

        if (data.length !== N) {
            console.error('입력된 데이터의 개수가 일치하지 않습니다.');
        } else {
            console.log(solution(data));  // solution 함수 호출
        }
        
        rl.close();  // 입력 완료 후 readline 인터페이스 닫기
    }
}).on('close', function () {
    process.exit(0);
});
