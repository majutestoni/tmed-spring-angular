import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-message-modal',
  templateUrl: './message-modal.component.html',
  styleUrls: ['./message-modal.component.scss'],
})
export class MessageModalComponent implements OnInit {
  @Input() title = '';
  @Input() message = '';
  @Input() icon = '';
  @Input() bntPrimary = '';
  constructor() {}

  ngOnInit(): void {}

  closeModal() {}
}
