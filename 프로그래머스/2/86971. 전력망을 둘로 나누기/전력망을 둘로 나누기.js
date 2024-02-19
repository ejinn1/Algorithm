class Tree {
  constructor(n) {
    this.tree = new Array(n);
    this.min = n - 1;
  }
    
  setConnect(v1, v2) {
    this.connect(v1, v2);
    this.connect(v2, v1);
  }
    
  connect(v, target) {
    const connects = this.tree[v - 1] || [];
    connects.push(target);
    this.tree[v - 1] = connects;
  }
    
  getCount(v, except) {
    const connects = this.tree[v - 1] || [];
    if (connects.length === 1) return 1;
    return connects.reduce((acc, cur) => {
      if (cur === except) return acc;
      return acc + this.getCount(cur, v);
    }, 1);
  }
    
  setDiff(v1, v2) {
    const diff = Math.abs(this.getCount(v1, v2) * 2 - this.tree.length)
    this.min = Math.min(this.min, diff);
  }
}

function solution(n, wires) {
  const tree = new Tree(n);
    
  wires.forEach(([v1, v2]) => tree.setConnect(v1, v2));
  wires.forEach(([v1, v2]) => tree.setDiff(v1, v2));
    
  return tree.min;
}