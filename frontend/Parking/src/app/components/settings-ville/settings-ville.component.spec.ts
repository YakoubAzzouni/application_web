import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SettingsVilleComponent } from './settings-ville.component';

describe('SettingsVilleComponent', () => {
  let component: SettingsVilleComponent;
  let fixture: ComponentFixture<SettingsVilleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SettingsVilleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SettingsVilleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
