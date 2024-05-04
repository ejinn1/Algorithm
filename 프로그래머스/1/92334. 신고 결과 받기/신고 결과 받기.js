function solution(id_list, report, k) {
    let obj1 = {}
    
    id_list.forEach((id) => {
        obj1[id] = []
    })
    
    report.forEach((r) => {
        r = r.split(' ')
        obj1[r[1]].push(r[0])
    })
    
    const result = {};

    id_list.forEach((i) => {
       result[i] = 0;
    });

    id_list.forEach((i) => {
        obj1[i] = Array(...new Set([...obj1[i]]));

        if(obj1[i].length >= k){
            obj1[i].forEach(j => {
                result[j]++;
            });
        }
    });
    
    return Object.values(result);
}