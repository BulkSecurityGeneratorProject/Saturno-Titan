import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'jhi-mwl-demo-utils-calendar-header',
    template: `
    <div class="row text-center">
      <div class="col-md-4">
        <div class="btn-group">
          <div
            class="btn btn-primary"
            mwlCalendarPreviousView
            [view]="view"
            [(viewDate)]="viewDate"
            (viewDateChange)="viewDateChange.next(viewDate)"
          >
            Anterior
          </div>
          <div
            class="btn btn-outline-secondary"
            mwlCalendarToday
            [(viewDate)]="viewDate"
            (viewDateChange)="viewDateChange.next(viewDate)"
          >
            Actual
          </div>
          <div
            class="btn btn-primary"
            mwlCalendarNextView
            [view]="view"
            [(viewDate)]="viewDate"
            (viewDateChange)="viewDateChange.next(viewDate)"
          >
            Siguiente
          </div>
        </div>
      </div>
      <div class="col-md-4">
        <h5>{{ viewDate | calendarDate: view + 'ViewTitle':locale }}</h5>
      </div>
      <div class="col-md-4">
        <div class="btn-group">
          <div
            class="btn btn-primary"
            (click)="viewChange.emit('month')"
            [class.active]="view === 'month'"
          >
            Mes
          </div>
          <div
            class="btn btn-primary"
            (click)="viewChange.emit('week')"
            [class.active]="view === 'week'"
          >
            Semana
          </div>
          <div
            class="btn btn-primary"
            (click)="viewChange.emit('day')"
            [class.active]="view === 'day'"
          >
            Día
          </div>
        </div>
      </div>
    </div>
    <br />
  `
})
export class CalendarHeaderComponent {
    @Input()
    view: string;

    @Input()
    viewDate: Date;

    @Input()
    locale = 'es';

    @Output()
    viewChange: EventEmitter<string> = new EventEmitter();

    @Output()
    viewDateChange: EventEmitter<Date> = new EventEmitter();
}
