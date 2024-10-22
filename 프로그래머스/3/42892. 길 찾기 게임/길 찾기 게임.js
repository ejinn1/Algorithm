function solution(nodeinfo) {
    // 1. 노드에 인덱스 붙이기 (노드 번호 1부터 시작)
    nodeinfo = nodeinfo.map((node, index) => [...node, index + 1]);
    
    // 2. y 값 기준 내림차순, y 값이 같으면 x 값 오름차순으로 정렬
    nodeinfo.sort((a, b) => b[1] - a[1] || a[0] - b[0]);

    // 3. 이진 트리 생성
    const tree = [];
    
    function insertNode(node){
        const [x, y, index] = node
        
        let current = tree[0]
        
        if(!current){
            tree.push({x, y, index, left: null, right: null})
            return
        }
        
        while(true){
            if(x < current.x){
                if(!current.left){
                    current.left = {x, y, index, left: null, right: null}
                    break
                } else {
                    current = current.left
                }
            } else {
                if(!current.right){
                    current.right = {x, y, index, left: null, right: null}
                    break
                } else {
                    current = current.right
                }
            }
        }
    }
    
    
    // 루트 노드부터 차례로 삽입
    nodeinfo.forEach((node) => insertNode(node))

    // 4. 전위 순회 (preorder)
    const preorder = [];
    function preOrder(node){
        if(!node) return
        preorder.push(node.index)
        preOrder(node.left)
        preOrder(node.right)
    }

    // 5. 후위 순회 (postorder)
    const postorder = [];
    function postOrder(node){
        if(!node) return
        postOrder(node.left)
        postOrder(node.right)
        postorder.push(node.index)
    }

    // 트리의 첫 번째 노드 (루트)를 기준으로 순회
    preOrder(tree[0]);
    postOrder(tree[0]);

    // 6. 결과 반환
    return [preorder, postorder]
}
