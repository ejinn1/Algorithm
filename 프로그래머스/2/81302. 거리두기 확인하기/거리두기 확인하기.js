function check(place){
    const direction = [[1, 0], [0, 1], [-1, 0], [0, -1]]

    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            if (place[i][j] === 'P') {
                for(const [dx, dy] of direction){
                    const cx = i + dx
                    const cy = j + dy
                    
                    if(cx >= 0 && cx < 5 && cy >= 0 && cy < 5 && place[cx][cy] === 'P'){
                        return 0
                    }
                }
            }
            if (place[i][j] === 'O') {
                let count = 0;
                for(const [dx, dy] of direction){
                    const cx = i + dx
                    const cy = j + dy
                    
                    if(cx >= 0 && cx < 5 && cy >= 0 && cy < 5 && place[cx][cy] === 'P'){
                        count += 1
                    }
                }
                if (count > 1) {
                    return 0;
                }
            }
        }
    }
    return 1;
};

function solution(places){
    return places.map((place) => check(place))
}