#include <stdio.h>
#include <stdlib.h>
#include "process.h"

Process process_ini(char* new_name, int bt)
{
    Process new_p;
    //create a new allocates memory of name
    new_p = malloc(sizeof(Process_struct));
    new_p->name = new_name;
    new_p->burst_time = bt;
    //initialize the strat time and finish time as 0
    new_p->start_time = 0;
    new_p->finish_time = 0;
    //initial the running status as false
    new_p->runing = false;
    //initialize the previous and next as NULL
    new_p->previous = NULL;
    new_p->next = NULL;
    return new_p;
}

void process_free(Process p)
{
    free(p->name);
    free(p);
}

void process_free_withoutname(Process p)
{
    free(p);
}

char* process_get_name(Process p)
{
    return p->name;
}

void process_set_st(Process p, int time)
{
    p->start_time = time;
}

void process_set_ft(Process p, int time)
{
    p->finish_time = time;
}

void process_set_bt(Process p, int time)
{
    p->burst_time = time;
}

int process_get_st(Process p)
{
    return p->start_time;
}

int process_get_ft(Process p)
{
    return p->finish_time;
}

int process_get_bt(Process p)
{
    return p->burst_time;
}

bool process_get_status(Process p)
{
    return p->runing;
}

void process_set_status(Process p, bool b)
{
    p->runing = b;
}

void process_set_next(Process p, Process next){
    p->next = next;
}

void process_set_previous(Process p, Process pre){
    p->previous = pre;
}

Process process_get_next(Process p){
    return p->next;
}

Process process_get_previous(Process p){
    return p->previous;
}
