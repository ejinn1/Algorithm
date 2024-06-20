function solution(relation) {
    const rows = relation.length;
    const cols = relation[0].length;
    const candidates = [];

    function isUnique(mask) {
        const seen = new Set();
        for (let row = 0; row < rows; row++) {
            let key = '';
            for (let col = 0; col < cols; col++) {
                if (mask & (1 << col)) {
                    key += relation[row][col] + '|';
                }
            }
            if (seen.has(key)) {
                return false;
            }
            seen.add(key);
        }
        return true;
    }

    function isMinimal(mask) {
        for (let candidate of candidates) {
            if ((candidate & mask) === candidate) {
                return false;
            }
        }
        return true;
    }

    for (let mask = 1; mask < (1 << cols); mask++) {
        if (isUnique(mask) && isMinimal(mask)) {
            candidates.push(mask);
        }
    }

    return candidates.length;
}
