#include <stdio.h>
#include "process.h"

//create a new struct of ready queue
//which include a list of process
typedef struct
{
    int q_num;
    int time_quantum;
    int num_of_process;
    Process head;
    Process tail;
}Ready_queue_struct;

//create a new struct of pointer which point to a Ready_queue_struct
typedef Ready_queue_struct* RQ;

//initialize a ready queue using num and time quantum
RQ rq_ini(int num, int tq);

//add a new process in the end of ready queue
void rq_add_process(RQ rq, Process p_new);

//delete the head of ready queue
void rq_delete_head(RQ rq);

//move the head to tail and reset the head and tail
void rq_headtotail(RQ rq);

//delete the given process in ready queue
void rq_delete(RQ rq, Process p);

//return the process with shortest burst time
Process rq_get_shortest(RQ rq);

Process rq_get_head(RQ rq);

Process rq_get_tail(RQ rq);

int rq_get_numofp(RQ rq);

int rq_get_tq(RQ rq);

int rq_get_num(RQ rq);

//free all the process in ready queue and itself
void rq_free(RQ rq, int count);








