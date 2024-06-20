function solution(gems) {
    const gemTypes = new Set(gems);
    const gemCount = gemTypes.size;
    const gemMap = new Map();
    let start = 0;
    let end = 0;
    let minStart = 0;
    let minEnd = gems.length - 1;

    for (end = 0; end < gems.length; end++) {
        // 현재 보석의 마지막 인덱스를 저장
        gemMap.set(gems[end], end);

        // 모든 보석 종류가 포함된 경우
        if (gemMap.size === gemCount) {
            // 현재 구간에서 가장 작은 인덱스를 찾음
            let minIndex = Math.min(...gemMap.values());

            // 구간의 길이를 계산하여 최적의 구간을 갱신
            if (end - minIndex < minEnd - minStart) {
                minStart = minIndex;
                minEnd = end;
            }

            // start를 증가시켜 다음 구간으로 이동
            start = minIndex + 1;
            gemMap.delete(gems[minIndex]);
        }
    }
    return [minStart + 1, minEnd + 1];
}
