function getPoint(n, r, c, board) {
    const visited = Array.from({ length: n }, () => Array(n).fill(0));
    const command = {
        U: [-1, 0],
        L: [0, -1],
        D: [1, 0],
        R: [0, 1],
    };
    let score = 1;
    // 방문한 곳이라면 게임 끝
    while (true) {
        const len = board[r][c].length - 1;
        const cnt = Number(board[r][c].slice(0, len));
        const com = board[r][c].slice(len);
		visited[r][c]=1;
        for (let i = 0; i < Number(cnt); i++) {
            let [nextR, nextC] = [r + command[com][0], c + command[com][1]];

            if (nextR === n) nextR = 0;
            if (nextR < 0) nextR = n - 1;
            if (nextC < 0) nextC = n - 1;            
            if (nextC === n) nextC = 0;
            
            // 종료 조건
            if (!visited[nextR][nextC]) {
                [r, c] = [nextR, nextC];
                visited[nextR][nextC] = 1;
                score++;
            } else {
                return score;
            }
        }
    }
}

function solution(n, input) {
    const [rg, cg] = input[0].map((el) => Number(el) - 1);
    const [rp, cp] = input[1].map((el) => Number(el) - 1);
    const board = input.slice(2);

    const goorm = ["goorm", getPoint(n, rg, cg, board)];
    const player = ["player", getPoint(n, rp, cp, board)];

    goorm[1] > player[1]
        ? console.log(goorm.join(" "))
        : console.log(player.join(" "));
}

const readline = require("readline");
let rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});
let input = [];
let n = null;
let cnt = 0;
rl.on("line", (line) => {
    if (!n) {
        n = +line;
    } else {
        input.push(line.split(" "));
        cnt++;
        if (cnt === n + 2) {
            rl.close();
        }
    }
});

rl.on("close", () => {
    solution(n, input);
});