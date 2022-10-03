// Time:O(2^N), Space:O(2^N)
class Hanoi {
    public long toh(int N, int from, int to, int aux) {
        if(N == 0) return 0;
        
        long from_aux = 1 + toh(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        long aux_to = toh(N - 1, aux, to, from);
        
        return from_aux + aux_to;
    }
}
