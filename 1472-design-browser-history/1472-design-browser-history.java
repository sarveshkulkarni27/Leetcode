class BrowserHistory {
    
    List<String> history;
    int page = 0;
    public BrowserHistory(String homepage) {
        history = new ArrayList<String>();
        history.add(homepage);
    }
    
    public void visit(String url) {
        if(history.size() > page){
            history.subList(page + 1, history.size()).clear();        
        }      
        history.add(url);
        page++;
    }
    
    public String back(int steps) {
        page = steps > page ? 0 : page - steps;
        return history.get(page);
    }
    
    public String forward(int steps) {
        page = (page + steps) >= history.size() ? history.size() - 1 : (page + steps);
        return history.get(page);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */