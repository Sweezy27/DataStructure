#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ready_queue.h"


RQ rq_ini(int num, int tq)
{
    RQ rq;
    //create a allocate memory for ready queue
    rq = malloc(sizeof(Ready_queue_struct));
    rq->q_num = num;
    rq->time_quantum = tq;
    rq->num_of_process = 0;
    //initialize the head and tail as NULL
    rq->head = NULL;
    rq->tail = NULL;
    return rq;
}

void rq_add_process(RQ rq, Process p_new)
{
    //if nothing in rq, set head and tail as the process given
    if(rq->num_of_process == 0){
        rq->head = p_new;
        rq->tail = p_new;
        rq->num_of_process++;
    }
    else
    {
        process_set_next(rq->tail, p_new);
        process_set_previous(p_new, rq->tail);
        rq->tail = p_new;
        rq->num_of_process++;
    }
}

void rq_delete_head(RQ rq)
{
    if(rq->num_of_process > 1)
    {
        Process tmp = rq->head;
        rq->head = process_get_next(tmp);
        process_set_previous(rq->head, NULL);
        //free the process without the name since need to access the name to output
        process_free_withoutname(tmp);
        rq->num_of_process--;
    }
    //if only 1 process in rq, delete and set head and tail as NULL
    else
    {
        Process tmp = rq->head;
        rq->head = NULL;
        rq->tail = NULL;
        //free the process without the name since need to access the name to output
        process_free_withoutname(tmp);
        rq->num_of_process--;
    }
}

void rq_headtotail(RQ rq){
    //check the numer of processes in rq
    //if only 1 process, do nothing
    if(rq->num_of_process > 1)
    {
        Process tmp = rq->head;
        rq->head = process_get_next(tmp);
        process_set_previous(rq->head, NULL);
        process_set_previous(tmp, rq->tail);
        process_set_next(rq->tail, tmp);
        process_set_next(tmp, NULL);
        rq->tail = tmp;
    }
}

void rq_delete(RQ rq, Process p)
{
    if(rq->num_of_process > 1)
    {
        //if the given process is the head, call the rq_delete_head() function
        if(strcmp(process_get_name(rq->head),process_get_name(p)) == 0)
        {
            rq_delete_head(rq);
        }
        //if the given process is the tail, delete and reset the tail
        else if(strcmp(process_get_name(rq->tail),process_get_name(p)) == 0)
        {
            process_set_next(process_get_previous(p), NULL);
            rq->tail = process_get_previous(p);
            //free the process without the name since need to access the name to output
            process_free_withoutname(p);
            rq->num_of_process--;
        }
        else
        {
            process_set_next(process_get_previous(p), process_get_next(p));
            process_set_previous(process_get_next(p), process_get_previous(p));
            //free the process without the name since need to access the name to output
            process_free_withoutname(p);
            rq->num_of_process--;
        }
    }
    //if only 1 process in rq, delete and reset the head and tail
    else
    {
        rq->head = NULL;
        rq->tail = NULL;
        //free the process without the name since need to access the name to output
        process_free_withoutname(p);
        rq->num_of_process--;
    }
}

Process rq_get_shortest(RQ rq)
{
    int min;
    Process tmp = rq->head;
    Process min_p = tmp;
    min = process_get_bt(tmp);
    //liner search all the process in rq
    for(int i = 0; i < rq->num_of_process - 1; i++)
    {
        tmp = process_get_next(tmp);
        if(process_get_bt(tmp) < min){
            min = process_get_bt(tmp);
            min_p = tmp;
        }
    }
    return min_p;
}

Process rq_get_head(RQ rq)
{
    return rq->head;
}

Process rq_get_tail(RQ rq)
{
    return rq->tail;
}

int rq_get_numofp(RQ rq)
{
    return rq->num_of_process;
}

int rq_get_tq(RQ rq)
{
    return rq->time_quantum;
}

int rq_get_num(RQ rq)
{
    return rq->q_num;
}

void rq_free(RQ rq, int count)
{
    for(int i = 0;i < count; i++)
    {
        Process freed = rq->head;
        rq->head = process_get_next(freed);
        process_free(freed);
    }
    free(rq);
}
