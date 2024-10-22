function solution(nodeinfo) {
    nodeinfo = nodeinfo.map((node, index) => [...node, index+1])
    
    nodeinfo.sort((a, b) => b[1] - a[1] || a[0] - b[0])
    
    const tree = []
    
    function insertNode(node){
        const [x, y, index] = node
        
        let current = tree[0]
        
        if(!current) {
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
    
    nodeinfo.forEach((node) => insertNode(node))
    
    const preorder = []
    function preOrder(node){
        if(!node) return
        preorder.push(node.index)
        preOrder(node.left)
        preOrder(node.right)
    }
    
    const postorder = []
    function postOrder(node){
        if(!node) return
        postOrder(node.left)
        postOrder(node.right)
        postorder.push(node.index)
    }
    
    preOrder(tree[0])
    postOrder(tree[0])
    
    return [preorder, postorder]
}
