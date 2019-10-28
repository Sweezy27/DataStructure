#include <stdio.h>
#include <stdbool.h>

//create a new struct of process
//which is avialible to create a list of process
typedef struct
{
    char* name;
    int burst_time;
    int start_time;
    int finish_time;
    bool runing;
    struct Process_struct* next;
    struct Process_struct* previous;
} Process_struct;

//create a new struct of a pointer to Process_struct
typedef Process_struct* Process;

//initial a process using name and burst time
Process process_ini(char* new_name, int bt);

char* process_get_name(Process p);

//free the allocate memory in process
void process_free(Process p);

//free the allocate memory in process without the name
void process_free_withoutname(Process p);

void process_set_st(Process p, int time);

void process_set_ft(Process p, int time);

void process_set_bt(Process p, int time);

int process_get_st(Process p);

int process_get_ft(Process p);

int process_get_bt(Process p);

//get the status for checking is running or not
bool process_get_status(Process p);

void process_set_status(Process p, bool b);

void process_set_next(Process p, Process next);

void process_set_previous(Process p, Process pre);

Process process_get_next(Process p);

Process process_get_previous(Process p);
