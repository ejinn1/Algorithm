function solution(n, k, enemy) {
    enemy = enemy.map((i) => i*(-1))
    // 최대 힙
    let heap = []
    let result = 0
    
    function swap(i, j){
        [heap[i], heap[j]] = [heap[j], heap[i]]
    }
    
    function Up(){
        let cur = heap.length - 1
        while(cur > 0){
            let parent = Math.floor((cur-1) / 2)
            if(heap[cur] <= heap[parent]) break
            swap(cur, parent)
            cur = parent
        }
    }
    
    function Down(){
        let cur = 0
        let len = heap.length
        while(true){
            let left = cur * 2 + 1
            let right = cur * 2 + 2
            let large = cur
            
            if (left < len && heap[left] > heap[large]) {
                large = left;
            }
            
            if (right < len && heap[right] > heap[large]) {
                large = right;
            }
            
            if (large === cur) break;
            swap(cur, large);
            cur = large;
        }   
    }
    
    function insert(value){
        heap.push(value)
        Up()
    }
    
    function maxPop(){
        if(heap.length === 0) return null
        let max = heap[0]
        let end = heap.pop()
        if(heap.length > 0){
            heap[0] = end
            Down()
        }
        
        return max
    }
    
    for(let i=0 ; i<enemy.length ; i++){
        insert(enemy[i])
        if(heap.length > k){
            n += maxPop()
        }
        
        if(n < 0) break
        result++
    }
    
    return result
}